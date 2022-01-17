$(document).ready(function () {
  let showPass = 0
  $('.btn-show-pass').on('click', function () {
    if (showPass == 0) {
      $(this).next('input').attr('type', 'text')
      $(this).find('i').removeClass('bi-eye-fill')
      $(this).find('i').addClass('bi-eye-slash-fill')
      showPass = 1
    } else {
      $(this).next('input').attr('type', 'password')
      $(this).find('i').addClass('bi-eye-fill')
      $(this).find('i').removeClass('bi-eye-slash-fill')
      showPass = 0
    }
  })
})