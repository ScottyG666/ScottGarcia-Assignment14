var userObj = JSON.parse(sessionStorage.getItem("sessionUser"));
console.log(userObj);


var chatroomSubmitBtn = document.getElementById('chatSubmitBtn')
var userIdField = document.querySelector('#usersId')
var userDesignationField = document.querySelector('#userDesignation')

//chatroomSubmitBtn.style.visibility="hidden"
userIdField.value = userObj.id
userDesignationField.value = userObj.username;


//following along with the Youtube tutorial
const chatForm = document.querySelector('#chatForm')
chatForm.addEventListener('submit' , e => {
    e.preventDefault()

    const formData = new FormData(this)
    fetch('/channels')
})
