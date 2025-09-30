set -e

EMAIL=$Email_Destino

echo -e "Subject: Resultado do Pipeline CI/CD\n\nPipeline executado com sucesso" | sendmail "$EMAIL"
