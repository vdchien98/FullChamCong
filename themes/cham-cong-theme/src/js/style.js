/*Hàm hiển thị khung confirm*/
function Confirm(title, msg, $true, $false, $id) { /*change*/
    var $content =  "<div class='dialog-ovelay'>" +
                    "<div class='dialog'><header class='text-center'>" +
                     " <h3 class='text-white font-weight-bold'> " + title + " </h3> " +
                     "<i class='fa fa-close'></i>" +
                 "</header>" +
                 "<div class='dialog-msg'>" +
                     " <h4> " + msg + " </h4> " +
                 "</div>" +
                 "<footer>" +
                     "<div class='controls text-center'>" +
                         " <button class='button button-danger doAction'>" + $true + "</button> " +
                         " <button class='button button-default cancelAction'>" + $false + "</button> " +
                     "</div>" +
                 "</footer>" +
              "</div>" +
            "</div>";
    $('body').prepend($content);
    $('.doAction').click(function () {
        
        $($id).submit();
        $(this).parents('.dialog-ovelay').fadeOut(500, function () {
            $(this).remove();
        });
    });
    $('.cancelAction, .fa-close').click(function () {
        $(this).parents('.dialog-ovelay').fadeOut(500, function () {
            $(this).remove();
      });
    });
}

/*Sử dụng mã zalo*/
function ConfirmChamCong(title, msg, $true, $false, $id) { /*change*/
    var $content =  "<div class='dialog-ovelay'>" +
                    "<div class='dialog'><header class='text-center'>" +
                     " <h3 class='text-white font-weight-bold'> " + title + " </h3> " +
                     "<i class='fa fa-close'></i>" +
                 "</header>" +
                 "<div class='dialog-msg'>" +
                     " <h4> " + msg + " </h4> " +
                     "<strong>Thời gian nhập mã xác nhận <span id='lblCount' class='text-danger'></span>&nbsp;giây.</strong> <br>" +
                     "<strong class='text-danger' id='ms-capcha'></strong>" +
                     "<label class='col-form-label font-weight-bold'>Nhập mã xác nhận <span class='text-danger'>(*)</span></label>" +
                     "<input type='number' name='popup-capcha' id='popup-capcha' class='form-control'  placeholder='Nhập mã xác nhận'>" +
                 "</div>" +
                 "<footer>" +
                     "<div class='controls text-center'>" +
                         " <button class='button button-danger doAction'>" + $true + "</button> " +
                         " <button class='button button-default cancelAction'>" + $false + "</button> " +
                     "</div>" +
                 "</footer>" +
              "</div>" +
            "</div>";
    $('body').prepend($content);
    $('.doAction').click(function () {
        if ($("#popup-capcha").val() != '') {

            $("input[name='capcha']").val($("#popup-capcha").val());
            $($id).submit();
            $(this).parents('.dialog-ovelay').fadeOut(500, function () {
                clearInterval(myVar);
                $(this).remove();
            });
        } else {
            $("#ms-capcha").html("Mã xác nhận không được để trống.");
        }
    });
    $('.cancelAction, .fa-close').click(function () {
        $(this).parents('.dialog-ovelay').fadeOut(500, function () {
            clearInterval(myVar);
            $(this).remove();
      });
    });
    var seconds = 30;
    $("#lblCount").html(seconds);
    var myVar = setInterval(function () {
        seconds--;
        $("#lblCount").html(seconds);
        if (seconds == 0) {
            clearInterval(myVar);
            $(".dialog-ovelay").remove();
        }
    }, 1000);
}

/*Không sử dụng mã zalo*/
function ConfirmChamCong1(title, msg, $true, $false, $id) { /*change*/
    var $content =  "<div class='dialog-ovelay'>" +
                    "<div class='dialog'><header class='text-center'>" +
                     " <h3 class='text-white font-weight-bold'> " + title + " </h3> " +
                     "<i class='fa fa-close'></i>" +
                 "</header>" +
                 "<div class='dialog-msg'>" +
                     " <h4> " + msg + " </h4> " +
                 "</div>" +
                 "<footer>" +
                     "<div class='controls text-center'>" +
                         " <button class='button button-danger doAction'>" + $true + "</button> " +
                         " <button class='button button-default cancelAction'>" + $false + "</button> " +
                     "</div>" +
                 "</footer>" +
              "</div>" +
            "</div>";
    $('body').prepend($content);
    $('.doAction').click(function () {
        $($id).submit();
        $(this).parents('.dialog-ovelay').fadeOut(500, function () {
            $(this).remove();
        });
    });
    $('.cancelAction, .fa-close').click(function () {
        $(this).parents('.dialog-ovelay').fadeOut(500, function () {
            $(this).remove();
      });
    });
}

function ConfirmMangNgoai(title, msg, $false) { /*change*/
    var $content =  "<div class='dialog-ovelay'>" +
                    "<div class='dialog'><header class='text-center'>" +
                     " <h3 class='text-white font-weight-bold'> " + title + " </h3> " +
                     "<i class='fa fa-close'></i>" +
                 "</header>" +
                 "<div class='dialog-msg'>" +
                     " <h4> " + msg + " </h4> " +
                 "</div>" +
                 "<footer>" +
                     "<div class='controls text-center'>" +
                         " <button class='button button-default cancelAction'>" + $false + "</button> " +
                     "</div>" +
                 "</footer>" +
              "</div>" +
            "</div>";
    $('body').prepend($content);

    $('.cancelAction, .fa-close').click(function () {
        $(this).parents('.dialog-ovelay').fadeOut(500, function () {
          $(this).remove();
      });
    });
}

function ConfirmXinChamCong(title, msg, $true, $false, $id) { /*change*/
    var $content =  "<div class='dialog-ovelay'>" +
                    "<div class='dialog'><header class='text-center'>" +
                     " <h3 class='text-white font-weight-bold'> " + title + " </h3> " +
                     "<i class='fa fa-close'></i>" +
                 "</header>" +
                 "<div class='dialog-msg'>" +
                     " <h4> " + msg + " </h4> " +
                     "<strong class='text-danger' id='ms-capcha'></strong> <br>" +
                     "<label class='col-form-label font-weight-bold'>Lý do <span class='text-danger'>(*)</span></label>" +
                     "<textarea rows='5' type='text' name='popup-ly-do' id='popup-ly-do' class='form-control'></textarea>" +
                 "</div>" +
                 "<footer>" +
                     "<div class='controls text-center'>" +
                         " <button class='button button-danger doAction'>" + $true + "</button> " +
                         " <button class='button button-default cancelAction'>" + $false + "</button> " +
                     "</div>" +
                 "</footer>" +
              "</div>" +
            "</div>";
    $('body').prepend($content);
    $('.doAction').click(function () {
        if ($("#popup-ly-do").val() != '') {

            $("textarea[name='ly_do']").val($("#popup-ly-do").val());
            $($id).submit();
            $(this).parents('.dialog-ovelay').fadeOut(500, function () {
                $(this).remove();
            });
        } else {
            $("#ms-capcha").html("Trường lý do không được để trống.");
        }
    });
    $('.cancelAction, .fa-close').click(function () {
        $(this).parents('.dialog-ovelay').fadeOut(500, function () {
            $(this).remove();
      });
    });
}

/*Hàm hiển thị khung popup ghi chú*/
function PopupGhiChu($user_id) { /*change*/
    var $ghichu = $("#ghi-chu-"+$user_id).val();
    var $content =  "<div class='dialog-ovelay'>" +
                    "<div class='dialog'><header class='text-center'>" +
                     " <h3 class='text-white font-weight-bold'> Lý do </h3> " +
                     "<i class='fa fa-close'>x</i>" +
                 "</header>" +
                 "<div class='dialog-msg'>" +
                     "<textarea rows='5' type='text' name='popup-ly-do' id='popup-ly-do' class='form-control'>" + $ghichu + "</textarea>" +
                 "</div>" +
                 "<footer>" +
                     "<div class='controls text-center'>" +
                         " <button class='button button-danger doAction'> Lưu </button> " +
                     "</div>" +
                 "</footer>" +
              "</div>" +
            "</div>";
    $('body').prepend($content);
    $('.doAction').click(function () {
        $("#ghi-chu-"+$user_id).val($("#popup-ly-do").val());
        $(this).parents('.dialog-ovelay').fadeOut(500, function () {
            $(this).remove();
        });
    });
    $('.cancelAction, .fa-close').click(function () {
        $(this).parents('.dialog-ovelay').fadeOut(500, function () {
            $(this).remove();
      });
    });
}