function submitUser() {
    var nom = document.getElementById("nom").value;
    var prenom = document.getElementById("prenom").value;
    var pwd = document.getElementById("pwd").value;

    var utilisateur = {
        nom: nom,
        prenom: prenom,
        pwd: pwd
    };

    fetch('http://localhost:8096/utilisateurs/add', { 
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(utilisateur)
    })
    .then(response => {
        if (response.ok) {
            return response.json(); // Récupérer la réponse JSON de la requête
        } else {
            throw new Error('Erreur lors de la création de l\'utilisateur');
        }
    })
    .then(data => {
        alert('Utilisateur créé avec succès!');
        if (pwd === "admin123") {
            // Redirection vers la page recette.html avec l'ID de l'utilisateur dans l'URL
            window.location.href = "recette.html?id=" + data;
        }
    })
    .catch(error => {
        console.error('Erreur:', error);
        alert('Erreur lors de la création de l\'utilisateur');
    });
}
