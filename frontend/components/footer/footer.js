class DaenaFooter extends HTMLElement {
  connectedCallback() {
    this.innerHTML = `

      <link rel="stylesheet" href="footer.css" />

      <footer class="rodape">
        <div class="rodape-topo">
          <div class="rodape-marca">
            <a href="index.html" class="logo-rodape">DaenaComu</a>
            <p>
              Oportunidades que conectam você ao futuro. Encontre cursos
              gratuitos, descubra novas profissões e compartilhe oportunidades.
            </p>
          </div>

          <ul class="rodape-links">
            <li><a href="sobreNos.html">Sobre nós</a></li>
            <li><a href="cursos.html">Catálogo de cursos</a></li>
            <li><a href="comunidade.html">Comunidade</a></li>
            <li><a href="testeVocacional.html">Teste vocacional</a></li>
            <li><a href="apoiar.html">Como apoiar</a></li>
          </ul>

          <div class="rodape-contato">
            <a href="mailto:contato@daenacomu.com.br" class="email-contato">
              contato@daenacomu.com.br
            </a>
            <div class="redes-sociais">
              <a href="#" aria-label="Instagram">
                <img src="img/instagram.svg" alt="Instagram" />
              </a>
              <a href="#" aria-label="YouTube">
                <img src="img/youtube.svg" alt="YouTube" />
              </a>
              <a href="#" aria-label="TikTok">
                <img src="img/tiktok.svg" alt="TikTok" />
              </a>
            </div>
          </div>
        </div>

        <div class="rodape-base">
          <p class="copyright">© 2026 DaenaComu. Todos os direitos reservados.</p>
          <div class="links-legais">
            <a href="privacidade.html">Privacidade</a>
            <a href="termos.html">Termos de uso</a>
            <a href="acessibilidade.html">Acessibilidade</a>
          </div>
        </div>
      </footer>
    `;
  }
}

customElements.define("daena-footer", DaenaFooter);
