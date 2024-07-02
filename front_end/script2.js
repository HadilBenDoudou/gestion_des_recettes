// Récupérer le paramètre id_chef de l'URL
function getChefIdFromUrl() {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get('id');
}

// Soumettre le formulaire d'ajout de recette
document.getElementById("recetteForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Empêcher le rechargement de la page par défaut

    var nom = document.getElementById("nom").value;
    var description = document.getElementById("description").value;
    var instruction = document.getElementById("instruction").value;
    var chefId = getChefIdFromUrl(); // Récupérer l'id_chef depuis l'URL

    var recette = {
        nom: nom,
        description: description,
        instruction: instruction,
        chefId: chefId // Ajouter l'id_chef à l'objet recette
    };

    // Envoyer la requête POST pour ajouter la recette
    fetch('http://localhost:8096/recettes/add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(recette)
    })
    .then(response => {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error('Erreur lors de l\'ajout de la recette');
        }
    })
    .then(data => {
        alert('Recette ajoutée avec succès!');
        // Rediriger vers une autre page ou effectuer d'autres actions après l'ajout de la recette
    })
    .catch(error => {
        console.error('Erreur:', error);
        alert('Erreur lors de l\'ajout de la recette');
    });
});
document.getElementById("ajouterRecetteLink").addEventListener("click", function() {
    document.getElementById("ajouterRecetteForm").style.display = "block";
    document.getElementById("listeRecettes").style.display = "none";
    document.body.classList.add("background"); // Ajoute la classe de fond d'écran
});

document.getElementById("listeRecettesLink").addEventListener("click", function() {
    document.getElementById("ajouterRecetteForm").style.display = "none";
    document.getElementById("listeRecettes").style.display = "block";
    document.body.classList.remove("background"); // Enlève la classe de fond d'écran
    fetchRecettes();
});

// Function to extract id_chef from the URL
// Function to fetch and display recipes
