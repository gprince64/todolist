$(document).ready(function(){
	$(".button-collapse").sideNav();
})

function submitForm(form){
	if(confirm("Voulez-vous vraiment terminer toutes les tâches de cet Utilisateur ?"))
		form.submit();
}