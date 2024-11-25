function clearUerr() {
    var username_err = document.getElementById("username_err");
    username_err.innerHTML = "&nbsp";
    let password_err = document.getElementById("password_err");
    password_err.innerHTML="&nbsp";
}
function clearPerr(){
    var password_err=document.getElementById("password_err");
    password_err.innerHTML="&nbsp";
}
function checkUsername() {
    var username = document.getElementById("username");
    var usernameValue = username.value.trim();
    var username_err=document.getElementById("username_err");
    if (usernameValue.length ===0) {
        username_err.innerHTML = "用户名不能为空！";
        flag=false;
    } else if (usernameValue.length <5 || usernameValue.length >12) {
        username_err.innerHTML = "用户名不符合要求！";
        flag=false;
    } else {
        username_err.innerHTML = "&nbsp";
        flag=true;
    }
    return flag;
}

function checkPassword() {
    var flag=false;
    var password = document.getElementById("password");
    var passwordValue = password.value.trim();
    var password_err = document.getElementById("password_err");
    if (passwordValue.length === 0) {
        flag=false;
        password_err.innerHTML = "密码不能为空！";
    } else if (passwordValue.length <5 || passwordValue.length >12) {
        flag=false;
        password_err.innerHTML = "密码不符合要求！";
    } else {
        flag=true;
        password_err.innerHTML = "&nbsp";
    }
    return flag;
}
// window.onload=function (){
//     var form=document.getElementById("form");
//     form.onsubmit=checkForm;
//     function checkForm() {
//         alert("输入不合法");
//         return checkUsername()&&checkPassword();
//     }
// }
function checkForm(){
    if (checkUsername()&&checkPassword()){
        return true;
    }
    else {
        alert("账号格式非法,请检查并修改后重新提交")
        return false
    }
}