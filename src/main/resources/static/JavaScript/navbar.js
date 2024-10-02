let closed;

window.onload=()=>{
    closed=true;
}

window.onresize=()=>{
    if(window.innerWidth>=600){
        document.getElementsByClassName("navlinks")[0].style.display="flex";
    }else{
        document.getElementsByClassName("navlinks")[0].style.display="none";
    }
}

document.getElementsByClassName("hamburger-menu")[0].onclick=()=>{
    nav_menu=document.getElementsByClassName("navlinks")[0];
    if(closed){
        nav_menu.style.display="flex";
    }else{
        nav_menu.style.display="none";
    }
    closed=!closed;
}