$("#login-button").click(() => {
  let usernameInput = document.getElementById("username-input-login");
  let passwordInput = document.getElementById("password-input-login");
  

  fetch("http://localhost:8081/checkuser", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      username: $("#username-input-login").val(),
      password: $("#password-input-login").val(),
    }),
  })
    .then((data) => data.json())
    .then((data) =>{
        if(data.ok == true){
            alert("logged in succefully!!");
        }else{
            if(data.error == "Invalid Username"){
                usernameInput.setCustomValidity(data.error);
                usernameInput.reportValidity();
            }else{
                passwordInput.setCustomValidity(data.error);
                passwordInput.reportValidity();
            }
        }
    });
});

$(".toggle-visibility").click(()=>{
    let passwordInput = $("#password-input-login");
    if(passwordInput.attr("type") == "password"){
        passwordInput.attr("type", "text");
        $(".toggle-visibility").attr("class", "far fa-eye-slash toggle-visibility");
    }else{
        passwordInput.attr("type", "password");
        $(".toggle-visibility").attr("class", "far fa-eye toggle-visibility");
    }
})
