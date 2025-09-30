set -e

EMAIL=$EMAIL_TO

ASSUNTO="Resultado do Pipeline CI/CD"
MENSAGEM="Pipeline executado com sucesso no repositório $GITHUB_REPOSITORY - branch $GITHUB_REF_NAME."

echo -e "Subject: $ASSUNTO\n\n$MENSAGEM" | sendmail "$EMAIL"
