// Em criarItem.js
async function criarItemWishlist() {
    console.log("ta funcionando");

    // CORREÇÃO: Use o ID correto que está no HTML
    let container = document.getElementById("wishlist-container"); 
    if (!container) {
        console.error("Elemento #wishlist-container não encontrado!");
        return;
    }
    
    container.innerHTML = "<p>Carregando...</p>"; // Limpa e mostra feedback
    let texto = "";

    const compromissos = await listarCompromissos();
    const itensWishlist = compromissos.filter(c => c.tipo === 'WISHLIST');

    // CORREÇÃO: Use a variável correta 'itensWishlist'
    if (itensWishlist.length > 0) {
        itensWishlist.forEach(element => {
            texto += `
                <div class="list-item">
                    <h3>${element.nome}</h3>
                    <p>${element.descricao}</p>
                </div>
            `;
        });
    } else {
        texto = "<p>Nenhum item na sua wishlist.</p>";
    }
    
    container.innerHTML = texto;
}
