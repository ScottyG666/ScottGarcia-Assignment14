var registerButton = document.querySelector("#registrationButton");
var designationInput = document.querySelector("#designation");
var hiddenId = document.querySelector("#id");

hiddenId.value = Date.now();

registerButton.addEventListener("click", () => {
  // adding the input from the input field to an object under "USERNAME"
  var user = {
    id: hiddenId.value,
    username: designationInput.value,
  };
  // SessinStorage can only hold string, so we must stringify the user to store it within the session
  sessionStorage.setItem("sessionUser", JSON.stringify(user));
});
