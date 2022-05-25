var registerButton = document.querySelector('#registrationButton')


registerButton.addEventListener( 'click', addUserToSessionStorage())


function addUserToSessionStorage () {
    
    var designationInput = document.querySelector('#designation')
    sessionStorage.setItem('username' , JSON.stringify({designation : designationInput}))
    console.log(designationInput.value)
}