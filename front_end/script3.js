document.getElementById("chefForm").addEventListener("submit", function(event) {
    event.preventDefault();

    var nom = document.getElementById("nom").value;
    var specialite = document.getElementById("specialite").value;
    var login = document.getElementById("login").value;
    var pwd = document.getElementById("pwd").value;

    var chefData = {
        nom: nom,
        specialite: specialite,
        login: login,
        pwd: pwd
    };

    fetch('http://localhost:8096/chef/ajouterChef', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(chefData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Erreur lors de l\'ajout du chef : ' + response.status);
        }
        return response.json();
    })
    .then(data => {
        // Vérifier si le mot de passe est 'admin123'
        if (pwd === 'admin123') {
            var chefId = data.idChef; // Récupérer l'ID du chef ajouté
            window.location.href = 'recette.html?id=' + chefId; // Rediriger avec l'ID du chef
        } else {
            alert('Chef ajouté avec succès, mais le mot de passe n\'est pas "admin123".');
        }
        // Réinitialiser les champs du formulaire
        document.getElementById('nom').value = '';
        document.getElementById('specialite').value = '';
        document.getElementById('login').value = '';
        document.getElementById('pwd').value = '';
        document.getElementById('error-message').innerText = '';
    })
    .catch(error => {
        document.getElementById('error-message').innerText = 'Erreur lors de l\'ajout du chef : ' + error.message;
    });
});
