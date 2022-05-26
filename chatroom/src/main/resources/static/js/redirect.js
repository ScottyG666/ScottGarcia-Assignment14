/*
        The sole purpose of this page is to check the session storage for an 
            assigned user designation, and if one it not found, redirects the user
            to the registration page so one may be assigned before proceeding within
             the application
             */

if (sessionStorage.getItem('sessionUser') === null) {
    window.location.replace('http://localhost:8080')
}