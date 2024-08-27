// Menu Del botón Responsive

// DOM de Javascript 
    // variables de manipulación
var menubtn = document.getElementById("btnMenuOpen"),

    menuresponsive = document.getElementById("menu-bar");



    menubtn.addEventListener("click",function(){

        // ciclo if - else 

        if(menuresponsive.className=="menu-bar"){

            menuresponsive.classList.add("active");
        }else{
            menuresponsive.classList.remove("active")
        }
    
        
    })

