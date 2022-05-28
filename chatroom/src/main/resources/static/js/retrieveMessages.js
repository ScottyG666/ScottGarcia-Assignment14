var chatBox = document.querySelector('#userMessage')


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









//triggers the form to submit when enter is pressed.
    //STILL NEED TO RECONFIGURE HOW SUBMIT POST HAPPENS W/ FETCH
chatBox.addEventListener( "keydown" , (event) => {

    //Checking if the Enter Key has been pressed
    if (  (window.event ? event.keyCode : e.witch) == 13) {
        //Submit text box form to chatroom
        document.forms[0].submit()
    }})


    /*
function present(e) {

    //Checking if the Enter Key has been pressed
    if (  (window.event ? event.keyCode : e.witch) == 13) {
        //Submit text box form to chatroom
        document.forms[0].submit()
    }
}
*/