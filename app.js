/**
 * UI/UX Logic Controller - User Registration & Success Confirmation Flow
 * Features: Inline validation, Fitts' law touch handling, Real-time strength meter,
 * Wireframe & UX Notes presentation mode toggles.
 */

document.addEventListener('DOMContentLoaded', () => {
  // Elements - View & Navigation
  const pageRegister = document.getElementById('pageRegister');
  const pageSuccess = document.getElementById('pageSuccess');
  const navPage1Btn = document.getElementById('navPage1Btn');
  const navPage2Btn = document.getElementById('navPage2Btn');
  
  // Mode Buttons
  const modeHifiBtn = document.getElementById('modeHifiBtn');
  const modeWireframeBtn = document.getElementById('modeWireframeBtn');
  const modeUxNotesBtn = document.getElementById('modeUxNotesBtn');
  const themeToggleBtn = document.getElementById('themeToggleBtn');

  // Form Fields
  const form = document.getElementById('registrationForm');
  const fullNameInput = document.getElementById('fullName');
  const emailInput = document.getElementById('email');
  const passwordInput = document.getElementById('password');
  const confirmPasswordInput = document.getElementById('confirmPassword');
  const agreeTermsCheckbox = document.getElementById('agreeTerms');
  const submitBtn = document.getElementById('submitBtn');

  // Toggle Password Visibilities
  const togglePasswordBtn = document.getElementById('togglePasswordBtn');
  const toggleConfirmPasswordBtn = document.getElementById('toggleConfirmPasswordBtn');

  // Password Strength Indicators
  const strengthSeg1 = document.getElementById('strengthSeg1');
  const strengthSeg2 = document.getElementById('strengthSeg2');
  const strengthSeg3 = document.getElementById('strengthSeg3');
  const strengthText = document.getElementById('strengthText');
  const critLength = document.getElementById('critLength');
  const critUpper = document.getElementById('critUpper');
  const critNumber = document.getElementById('critNumber');
  const critSpecial = document.getElementById('critSpecial');

  // Page 2 Summary Elements
  const registeredEmailDisplay = document.getElementById('registeredEmailDisplay');
  const summaryFullName = document.getElementById('summaryFullName');
  const summaryEmail = document.getElementById('summaryEmail');
  const summaryTimestamp = document.getElementById('summaryTimestamp');
  const btnGoToDashboard = document.getElementById('btnGoToDashboard');
  const btnResendEmail = document.getElementById('btnResendEmail');
  const resendBtnText = document.getElementById('resendBtnText');
  const btnBackToRegister = document.getElementById('btnBackToRegister');

  // Icons
  const checkIconSvg = `<svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="#10b981" stroke-width="2.5"><polyline points="20 6 9 17 4 12"/></svg>`;
  const errorIconSvg = `<svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="#ef4444" stroke-width="2.5"><circle cx="12" cy="12" r="10"/><line x1="15" y1="9" x2="9" y2="15"/><line x1="9" y1="9" x2="15" y2="15"/></svg>`;

  /* ==========================================================================
     1. Page Navigation & View Switcher
     ========================================================================== */
  function switchPage(pageNumber) {
    if (pageNumber === 1) {
      pageRegister.classList.add('active');
      pageSuccess.classList.remove('active');
      navPage1Btn.classList.add('active');
      navPage2Btn.classList.remove('active');
    } else {
      pageRegister.classList.remove('active');
      pageSuccess.classList.add('active');
      navPage1Btn.classList.remove('active');
      navPage2Btn.classList.add('active');
    }
  }

  navPage1Btn.addEventListener('click', () => switchPage(1));
  navPage2Btn.addEventListener('click', () => switchPage(2));
  btnBackToRegister.addEventListener('click', (e) => {
    e.preventDefault();
    switchPage(1);
  });

  /* ==========================================================================
     2. Mode Switcher (Hi-Fi / Wireframe / UX Annotations)
     ========================================================================== */
  function setDisplayMode(mode) {
    document.body.classList.remove('mode-wireframe', 'mode-annotations');
    modeHifiBtn.classList.remove('active');
    modeWireframeBtn.classList.remove('active');
    modeUxNotesBtn.classList.remove('active');

    if (mode === 'wireframe') {
      document.body.classList.add('mode-wireframe');
      modeWireframeBtn.classList.add('active');
    } else if (mode === 'annotations') {
      document.body.classList.add('mode-annotations');
      modeUxNotesBtn.classList.add('active');
    } else {
      modeHifiBtn.classList.add('active');
    }
  }

  modeHifiBtn.addEventListener('click', () => setDisplayMode('hifi'));
  modeWireframeBtn.addEventListener('click', () => setDisplayMode('wireframe'));
  modeUxNotesBtn.addEventListener('click', () => setDisplayMode('annotations'));

  /* ==========================================================================
     3. Dark / Light Theme Toggle
     ========================================================================== */
  themeToggleBtn.addEventListener('click', () => {
    const currentTheme = document.documentElement.getAttribute('data-theme');
    const newTheme = currentTheme === 'light' ? 'dark' : 'light';
    document.documentElement.setAttribute('data-theme', newTheme);
  });

  /* ==========================================================================
     4. Show / Hide Password Toggles
     ========================================================================== */
  function setupPasswordToggle(button, input) {
    button.addEventListener('click', () => {
      const isPassword = input.type === 'password';
      input.type = isPassword ? 'text' : 'password';
      button.title = isPassword ? 'Ẩn mật khẩu' : 'Hiện mật khẩu';
      button.innerHTML = isPassword
        ? `<svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M17.94 17.94A10.07 10.07 0 0 1 12 20c-7 0-11-8-11-8a18.45 18.45 0 0 1 5.06-5.94M9.9 4.24A9.12 9.12 0 0 1 12 4c7 0 11 8 11 8a18.5 18.5 0 0 1-2.16 3.19m-6.72-1.07a3 3 0 1 1-4.24-4.24"/><line x1="1" y1="1" x2="23" y2="23"/></svg>`
        : `<svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M1 12s4-8 11-8 11 8 11 8-4 8-11 8-11-8-11-8z"/><circle cx="12" cy="12" r="3"/></svg>`;
    });
  }
  setupPasswordToggle(togglePasswordBtn, passwordInput);
  setupPasswordToggle(toggleConfirmPasswordBtn, confirmPasswordInput);

  /* ==========================================================================
     5. Real-Time Form Validation (Inline Feedback & Error Prevention)
     ========================================================================== */
  function setFieldState(groupId, iconId, msgId, isValid, message) {
    const group = document.getElementById(groupId);
    const icon = iconId ? document.getElementById(iconId) : null;
    const msg = msgId ? document.getElementById(msgId) : null;

    if (!group) return;

    if (isValid === true) {
      group.classList.remove('has-error');
      group.classList.add('has-success');
      if (icon) {
        icon.innerHTML = checkIconSvg;
        icon.classList.add('visible');
      }
      if (msg) msg.textContent = message || 'Hợp lệ';
    } else if (isValid === false) {
      group.classList.remove('has-success');
      group.classList.add('has-error');
      if (icon) {
        icon.innerHTML = errorIconSvg;
        icon.classList.add('visible');
      }
      if (msg) msg.textContent = message || 'Vui lòng kiểm tra lại thông tin.';
    } else {
      group.classList.remove('has-error', 'has-success');
      if (icon) icon.classList.remove('visible');
      if (msg) msg.textContent = message || '';
    }
  }

  // Validate Full Name
  function validateFullName() {
    const val = fullNameInput.value.trim();
    if (!val) {
      setFieldState('groupFullName', 'iconFullName', 'msgFullName', false, 'Họ và tên không được để trống.');
      return false;
    }
    const words = val.split(/\s+/).filter(Boolean);
    if (words.length < 2) {
      setFieldState('groupFullName', 'iconFullName', 'msgFullName', false, 'Vui lòng nhập cả họ và tên (tối thiểu 2 từ).');
      return false;
    }
    setFieldState('groupFullName', 'iconFullName', 'msgFullName', true, 'Họ và tên hợp lệ.');
    return true;
  }

  // Validate Email (RFC 5322 Standard)
  function validateEmail() {
    const val = emailInput.value.trim();
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!val) {
      setFieldState('groupEmail', 'iconEmail', 'msgEmail', false, 'Email không được để trống.');
      return false;
    }
    if (!emailPattern.test(val)) {
      setFieldState('groupEmail', 'iconEmail', 'msgEmail', false, 'Định dạng email chưa đúng (VD: ten@domain.com).');
      return false;
    }
    setFieldState('groupEmail', 'iconEmail', 'msgEmail', true, 'Địa chỉ email hợp lệ.');
    return true;
  }

  // Password Complexity Calculation
  function calculatePasswordStrength(pass) {
    let score = 0;
    const hasLength = pass.length >= 8;
    const hasUpper = /[A-Z]/.test(pass);
    const hasNumber = /[0-9]/.test(pass);
    const hasSpecial = /[!@#$%^&*(),.?":{}|<>]/.test(pass);

    // Update Criteria Checklist
    critLength.classList.toggle('valid', hasLength);
    critUpper.classList.toggle('valid', hasUpper);
    critNumber.classList.toggle('valid', hasNumber);
    critSpecial.classList.toggle('valid', hasSpecial);

    if (hasLength) score++;
    if (hasUpper) score++;
    if (hasNumber) score++;
    if (hasSpecial) score++;

    return { score, hasLength, hasUpper, hasNumber, hasSpecial };
  }

  function validatePassword() {
    const val = passwordInput.value;
    const { score, hasLength, hasUpper, hasNumber, hasSpecial } = calculatePasswordStrength(val);

    // Reset bar classes
    strengthSeg1.className = 'strength-segment';
    strengthSeg2.className = 'strength-segment';
    strengthSeg3.className = 'strength-segment';

    if (!val) {
      strengthText.textContent = 'Chưa nhập';
      strengthText.style.color = 'inherit';
      return false;
    }

    if (score <= 2) {
      strengthText.textContent = 'Yếu';
      strengthText.style.color = 'var(--danger)';
      strengthSeg1.classList.add('active-weak');
    } else if (score === 3) {
      strengthText.textContent = 'Trung bình';
      strengthText.style.color = 'var(--warning)';
      strengthSeg1.classList.add('active-medium');
      strengthSeg2.classList.add('active-medium');
    } else {
      strengthText.textContent = 'Mạnh & An toàn';
      strengthText.style.color = 'var(--success)';
      strengthSeg1.classList.add('active-strong');
      strengthSeg2.classList.add('active-strong');
      strengthSeg3.classList.add('active-strong');
    }

    if (confirmPasswordInput.value) {
      validateConfirmPassword();
    }

    return hasLength && score >= 2;
  }

  // Validate Confirm Password
  function validateConfirmPassword() {
    const val = confirmPasswordInput.value;
    const pass = passwordInput.value;

    if (!val) {
      setFieldState('groupConfirmPassword', 'iconFullName', 'msgConfirmPassword', false, 'Vui lòng xác nhận mật khẩu.');
      return false;
    }
    if (val !== pass) {
      setFieldState('groupConfirmPassword', 'iconFullName', 'msgConfirmPassword', false, 'Mật khẩu xác nhận không trùng khớp.');
      return false;
    }
    setFieldState('groupConfirmPassword', 'iconFullName', 'msgConfirmPassword', true, 'Mật khẩu xác nhận trùng khớp!');
    return true;
  }

  // Real-time Event Listeners
  fullNameInput.addEventListener('input', validateFullName);
  emailInput.addEventListener('input', validateEmail);
  passwordInput.addEventListener('input', validatePassword);
  confirmPasswordInput.addEventListener('input', validateConfirmPassword);

  /* ==========================================================================
     6. Form Submission Handling
     ========================================================================== */
  form.addEventListener('submit', (e) => {
    e.preventDefault();

    const isNameValid = validateFullName();
    const isEmailValid = validateEmail();
    const isPassValid = validatePassword();
    const isConfirmValid = validateConfirmPassword();
    const isTermsValid = agreeTermsCheckbox.checked;

    if (!isTermsValid) {
      alert('Vui lòng chấp nhận Điều khoản dịch vụ và Chính sách bảo mật để tiếp tục.');
      agreeTermsCheckbox.focus();
      return;
    }

    if (isNameValid && isEmailValid && isPassValid && isConfirmValid) {
      // Button loading state micro-interaction
      submitBtn.disabled = true;
      submitBtn.innerHTML = `<span>Đang khởi tạo tài khoản...</span>`;

      setTimeout(() => {
        // Collect & Update Page 2 Data
        const userFullName = fullNameInput.value.trim();
        const userEmail = emailInput.value.trim();
        const now = new Date();
        const formattedDate = `${String(now.getDate()).padStart(2, '0')}/${String(now.getMonth() + 1).padStart(2, '0')}/${now.getFullYear()} lúc ${String(now.getHours()).padStart(2, '0')}:${String(now.getMinutes()).padStart(2, '0')}`;

        registeredEmailDisplay.textContent = userEmail;
        summaryFullName.textContent = userFullName;
        summaryEmail.textContent = userEmail;
        summaryTimestamp.textContent = formattedDate;

        // Reset submit button
        submitBtn.disabled = false;
        submitBtn.innerHTML = `<span>Hoàn tất đăng ký tài khoản</span><svg class="btn-arrow-icon" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M5 12h14"/><path d="m12 5 7 7-7 7"/></svg>`;

        // Navigate to Success Screen (Trang 2)
        switchPage(2);
        window.scrollTo({ top: 0, behavior: 'smooth' });
      }, 500);
    }
  });

  /* ==========================================================================
     7. Page 2 Actions: Resend Verification Email Countdown & Dashboard
     ========================================================================== */
  let countdownTimer = null;
  btnResendEmail.addEventListener('click', () => {
    if (btnResendEmail.disabled) return;

    let timeLeft = 60;
    btnResendEmail.disabled = true;
    resendBtnText.textContent = `Đã gửi lại! Vui lòng chờ (${timeLeft}s)`;

    countdownTimer = setInterval(() => {
      timeLeft--;
      if (timeLeft <= 0) {
        clearInterval(countdownTimer);
        btnResendEmail.disabled = false;
        resendBtnText.textContent = 'Gửi lại email kích hoạt';
      } else {
        resendBtnText.textContent = `Đã gửi lại! Vui lòng chờ (${timeLeft}s)`;
      }
    }, 1000);
  });

  btnGoToDashboard.addEventListener('click', () => {
    alert('Chào mừng ' + summaryFullName.textContent + '! Bạn đang được điều hướng đến trang Bảng điều khiển học viên CodeGym.');
  });
});
