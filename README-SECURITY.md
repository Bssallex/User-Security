🔐 Configuração de Chaves JWT (RSA)

Este projeto utiliza autenticação baseada em JWT assinado com RSA (chave pública e privada). 
Por motivos de segurança, as chaves não estão incluídas no repositório.

⚙️ Como gerar suas próprias chaves( certifique-se de ter o OpenSSL instalado)

01 - Gerar chave privada: openssl genrsa -out authz.pem 
02 - Gerar chave pública: openssl rsa -in authz.pem -pubout -out authz.pub
   
📁 Onde colocar as chaves

Crie uma pasta fora do projeto: mkdir -p ~/keys

Mova os arquivos:

mv authz.pem ~/keys/
mv authz.pub ~/keys/

⚙️ Configurar no application.yaml

Atualize o arquivo:

jwt:
public:
key: file:/home/SEU_USUARIO/keys/authz.pub
private:
key: file:/home/SEU_USUARIO/keys/authz.pem

Substitua "SEU_USUARIO" pelo seu usuário do sistema.

Agora o projeto está configurado para gerar e validar tokens JWT com segurança.