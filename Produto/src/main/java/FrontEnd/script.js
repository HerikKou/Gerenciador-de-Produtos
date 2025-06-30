async function salvarProduto() {

    const nomeProdutoInput = document.getElementById("nome").value;
    const precoInput = document.getElementById("preco").value;
    const quantidadeInput = document.getElementById("quantidade").value;
    const dados = {
        "nome": nomeProdutoInput,
        "preco": precoInput,
        "quantidade": quantidadeInput
    }

    try {
        const resp = await fetch("http://localhost:8080/api/produto/salvar", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(dados),
        })
        if (!resp.ok) {
            throw new Error(`Erro ao salvar produto: ${resp.status}`)
        }
        const data = await resp.json();
        document.getElementById("mensagem").textContent = "Produto salvo com sucesso!";
        document.getElementById("resultado").innerHTML =
            `ID: ${data.id}<br>Nome: ${data.nome}<br>Preço: R$${data.preco.toFixed(2)}<br>Quantidade: ${data.quantidade}`;
    } catch (error) {
        alert("Erro")
    }
}
async function BuscarProduto() {
    const idInput = document.getElementById("id").value;
    const dados = {
        "id": idInput
    }
    try {
        const resp = await fetch(`http://localhost:8080/api/produto/buscar/${dados.id}`, {
            method: "GET",
            headers: { "Content-Type": "application/json" },
            
        })
        if (!resp.ok) {
            throw new Error(`Erro ao deletar produto: ${resp.status}`)
        }
        const data = await resp.json()
        document.getElementById("mensagem").textContent = "Produto encontrado!";
        document.getElementById("resultado").innerHTML = `ID: ${data.id}<br>Nome: ${data.nome}<br>Preço: R$${parseFloat(data.preco).toFixed(2)}<br>Quantidade: ${data.quantidade}`;
    } catch (error) {
        document.getElementById("mensagem").textContent = "Produto não encontrado.";
        document.getElementById("resultado").innerHTML = "";
    }
}
async function deletarProduto() {
    const idInput = document.getElementById("id").value;
    const dados = {
        "id": idInput
    }
    try {
        const resp = await fetch(`http://localhost:8080/api/produto/buscar/${dados.id}`, {
            method: "GET",
            headers: { "Content-Type": "application/json" },
            
        })
        if (!resp.ok) {
            throw new Error(`Erro ao deletar produto: ${resp.status}`)
        }
        const data = await resp.json()
        document.getElementById("mensagem").textContent = "Produto excluido com sucesso!";
        document.getElementById("resultado").innerHTML = "Produto excluido com sucesso!"
    } catch (error) {
        document.getElementById("mensagem").textContent = "Erro ao excluir produto";
        document.getElementById("resultado").innerHTML = "Produto excluido com sucesso!";
    }
}
