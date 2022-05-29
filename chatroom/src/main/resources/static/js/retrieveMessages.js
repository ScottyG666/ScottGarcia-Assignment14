const chatBox = document.getElementById("formTextArea")
// Sets an event listener on the TextArea to POST the form upon
//  pressing *Enter* on a traditional keyboard INSTEAD of going
//  to a new line
chatBox.addEventListener('keypress', e => {
    if(e.which === 13) {
        console.log(e.target.value)
        e.target.form.dispatchEvent(new Event("submit" , {cancelable: true}));
        e.preventDefault();
        e.target.value = "";
    }
})








/*
document.getElementById('chatForm').addEventListener('submit' , event => {
    event.preventDefault();
    console.log('form submitted')
})

*/



/*
//queries the document for the form that the 
//  Users Text will submitting to
const chatForm = document.querySelector('#chatForm')
//when the form submits, stops browser from refreshing page
//  so the POST fetch can take place instead, without refreshing
//  the window
chatForm.addEventListener('submit' , e => {
    e.preventDefault()
    const formData = new FormData(this)
    fetch(`http://localhost:8080/channels` , {
        method : "POST" ,
        headers : {
            "Content-Type" : "application/json"
        },
        body : `{}`
    })
})



//Write the query that will  reach out to the GETMAPPING("/channels/{channelID}") to retrieve
//  the messages contained  within the channels  ${messages} list and add them to  the view
function fetchMessagesForDisplay () {
    
}

*/