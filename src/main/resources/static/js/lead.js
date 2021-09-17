
function onClickStatusValue(){
    let selectedValue = document.getElementById("status").value;
    let oppId = (new URL(document.location)).searchParams.get("id")
    fetch('/leads/update', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({id: oppId, status: selectedValue})
    }).then(res => res.json())
        .then(res => {
            console.log(res)
            if(res.status === "success"){
                let bannerDiv = document.getElementById("banner")
                document.getElementById("bannerText").innerText = "Successfully updated status"
                bannerDiv.classList.toggle("alert-success", true)
                if(bannerDiv.attributes.getNamedItem("hidden")){
                    bannerDiv.attributes.removeNamedItem("hidden")
                }
                setPathChevron(selectedValue)
            }else{
                document.getElementById("bannerText").innerText = "Failed to update status"
                document.getElementById("banner").classList.toggle("alert-warning",true)
            }

        });
}

function closeBanner(){
    let bannerDiv = document.getElementById("banner")
    bannerDiv.setAttribute("hidden","true")
    bannerDiv.classList.toggle("alert-success")
    bannerDiv.classList.toggle("alert-warning")
}

function setPathChevron(leadStatus){
    let acceptedDiv = document.getElementById("acceptedChevron")
    let inProgressDiv = document.getElementById("inProgressChevron")
    let closedDiv = document.getElementById("closedChevron")
    if (leadStatus === 'New'){
        acceptedDiv.classList.toggle("barBackgroundLight",true)
        inProgressDiv.classList.toggle("barBackgroundLight",true)
        closedDiv.classList.toggle("barBackgroundLight", true)
    }else if(leadStatus === 'Accepted'){
        acceptedDiv.classList.toggle("barBackgroundLight",false)
        inProgressDiv.classList.toggle("barBackgroundLight",true)
        closedDiv.classList.toggle("barBackgroundLight", true)
    }else if(leadStatus === 'In_Progress'){
        acceptedDiv.classList.toggle("barBackgroundLight",false)
        inProgressDiv.classList.toggle("barBackgroundLight",false)
        closedDiv.classList.toggle("barBackgroundLight", true)
    }else if(leadStatus === 'Closed'){
        acceptedDiv.classList.toggle("barBackgroundLight",false)
        inProgressDiv.classList.toggle("barBackgroundLight",false)
        closedDiv.classList.toggle("barBackgroundLight", false)
    }
}

function clickViewBtn(){
    let custInfoEmail = document.getElementById("custInfoEmail")
    let custInfoEmailHidden = document.getElementById("custInfoEmailHidden")
    let custInfoPhone = document.getElementById("custInfoPhone")
    let custInfoPhoneHidden = document.getElementById("custInfoPhoneHidden")

    if(custInfoEmail.attributes.getNamedItem("hidden")){
        custInfoEmail.attributes.removeNamedItem("hidden")
    }
    if(!custInfoEmailHidden.attributes.getNamedItem("hidden")){
        custInfoEmailHidden.setAttribute("hidden", "true")
    }
    if(custInfoPhone.attributes.getNamedItem("hidden")){
        custInfoPhone.attributes.removeNamedItem("hidden")
    }
    if(!custInfoPhoneHidden.attributes.getNamedItem("hidden")){
        custInfoPhoneHidden.setAttribute("hidden", "true")
    }
    document.getElementById("viewBtn").setAttribute("hidden", "true")
}
