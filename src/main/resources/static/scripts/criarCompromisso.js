

async function criarCompromissoWIshlist() {
    const novoItem = {
        nome: document.getElementById("nomeTexto").value,
        descricao: document.getElementById("descricaoTexto").value,
        tipo: "WISHLIST",
        paiId: "c8aa6324-75e4-42f4-9715-d1eac6ea584c"
    }

    try{
        const response = await fetch(urlCompromissos, {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(novoItem)
        })
          if (!response.ok) {
            alert("não foi possivel criar o item")
            throw new Error(`Erro na requisição: ${response.status} ${response.statusText}`);
        }

        const data = await response.json();

        console.log('Item adicionado com sucesso:', data);
        alert("item adicionado com sucesso")
        window.location.href = '/wishlist.html'
        return data; 
    } catch (error) {
        console.error('Falha ao adicionar item:', error);
    }
}
