
async function criarCompromissoWIshlist() {
    const novoItem = {
        nome: document.getElementById("nomeTexto").value,
        descricao: document.getElementById("descricaoTexto").value,
        tipo: "WISHLIST",
        paiId: "c8aa6324-75e4-42f4-9715-d1eac6ea584c"
    };

    try {
        const response = await fetch(urlCompromissos, {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(novoItem)
        });

        if (!response.ok) {
            alert("Não foi possível criar o item");
            throw new Error(`Erro na requisição: ${response.status}`);
        }

        const data = await response.json();
        console.log('Item adicionado com sucesso:', data);
        alert("Item adicionado com sucesso");
        
        window.location.assign('../templates/wishlist.html');

        return data; 

    } catch (error) {
        console.error('Falha ao adicionar item:', error);
    }
}