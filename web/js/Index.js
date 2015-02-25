
function DeleteCookies() {
    document.cookie = "username=";
    document.cookie = "password=";
}

/*
 // Return Client Cookie
 */
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
    }
    return "";
}

function CreateAuthHeader() {
    var password = getCookie("password");

    return { "Authorization": "Basic " + password };
}

function getUrlVars(name) {
    return decodeURI(
        (RegExp(name + '=' + '(.+?)(&|$)').exec(location.search) || [, null])[1]
    );
}

//check input is valid and not empty
function IsValid(Input) {
    if (Input == undefined) return false;
    if (Input == "") return false;
    if (Input == null) return false;
    if (Input == "null") return false;
    if (Input == "undefined") return false;
    return true;
}

    $.ajax({
        url: url + '/example',
        type: "post",
        headers: CreateAuthHeader(),
        data: JSON.stringify(),
        contentType: 'application/json',
        success: function (result) {

        },
        error: function (xhr, ajaxOptions, thrownError) {

        }
    });

