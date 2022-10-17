const inputBtn = document.getElementById("input-btn");
const inputEl = document.getElementById("input-el");
const ulEl = document.getElementById("ul-el");
let myLeads = ["www.facebook.com", "www.linkedin.com"];

inputBtn.addEventListener("click", function() {
    myLeads.push(inputEl.value);
    console.log(myLeads);
})

for(let i = 0; i < myLeads.length; i++){
    ulEl.textContent += myLeads[i];
}