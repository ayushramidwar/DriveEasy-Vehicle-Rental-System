console.log("DriveEasy Loaded Successfully");

function calculateTotal(){
    let start = document.getElementById("startDate").value;

    let end = document.getElementById("endDate").value;

    let startDate = new Date(start);
    let endDate = new Date(end);

    let diff = endDate = startDate;

    let days = diff/(1000*60*60*24);

    let pricePerDay = 2500;

    let total = days * pricePerDay;

    if(days>0){
        document.getElementById("days").innerHTML = "Total Days :" + days;
        document.getElementById("amount").innerHTML = "Total Cost :" + total;

    }
    else
   {
   alert("Invalid Date Selection");
   }
}

async function registerUser(){
const user = {
name: document.getElementById("name").value,
email: document.getElementById("email").value,
phone: document.getElementById("phone").value,
password: document.getElementById("password").value,
};
const response = await fetch(
 "http://localhost:8080/api/users/register",
 {
 method :"POST",
 headers:{
    "Content-type" : "application/json"
 },
 body: JSON.stringify(user)
 }
);
if(response.ok){
alert("Registration Successful");
window.location.href = "login.html";
}
else{
alert("Registration Failed")
}
}
async function loginUser(){
    const data = {
        email:document.getElementById("loginEmail").value,
        password:document.getElementById("loginPassword").value
    };
    const response = await fetch("https://localhost:8080/api/users/login",
    {
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body:json.stringify(data)
    });
    const user= await response.json();

    if(user){
        localStorage.setItem("loggedUser", JSON.stringify(user));
        alert("Login Successful");
        window.location.href = "dashboard.html";
    }
    else{
        alert("Invalid Credentials");
    }
}