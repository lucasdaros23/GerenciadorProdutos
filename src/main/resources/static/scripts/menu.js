async function popularMenu(){
    const compromissos = await listarCompromissos();

    popularCalendario(compromissos);
    popularWishlist(compromissos);
}