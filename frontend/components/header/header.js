class DaenaHeader extends HTMLElement {
  connectedCallback() {
    this.innerHTML = `

    <link rel="stylesheet" href="header.css" />


      <header class="cabecalho">
        <a href="index.html" class="logo">
          <img
            src="img/LOGO DESKTOP.svg"
            alt="Ícone DaenaComu"
            class="logo-img"
          />
          <span>DaenaComu</span>
        </a>

        <nav>
          <a class="link" href="cursos.html">CURSOS</a>
          <a class="link" href="comunidade.html">COMUNIDADE</a>
          <a class="link" href="apoiar.html">COMO APOIAR</a>
          <a class="link" href="sobreNos.html">SOBRE NÓS</a>
          <a class="botao" href="login.html" id="login">LOGIN</a>
        </nav>
      </header>
      <div class="faixa-azul"></div>
    `;
  }
}

customElements.define("daena-header", DaenaHeader);
