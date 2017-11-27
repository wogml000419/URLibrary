$(document).ready(function() {
  $('#transparent-bg').css('height', '213.6px')

    $('#main-carousel').on('slide.bs.carousel', function (e) {
      var id = '#item' + e.to
      var height = parseFloat($('#title-area').css('height')) 
      + parseFloat($(id).css('height'))
      + parseFloat($('#transparent-bg').css('padding-top'))
      + parseFloat($('#transparent-bg').css('padding-bottom'))
      + parseFloat($('h3').css('margin-bottom'))      
      
      console.log($('#transparent-bg').css('height') + ' -> ' + height + 'px')
      
      $('#transparent-bg').css('height', height + 'px')
    })
})
