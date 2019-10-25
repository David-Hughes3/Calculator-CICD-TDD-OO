sudo -i -u vagrant /usr/local/bin/ngrok http 8080 > /dev/null &
curl --silent http://localhost:4040/api/tunnels | jq '.tunnels[0].public_url'
export WEBHOOK_URL=$(curl --silent http://localhost:4040/api/tunnels | jq '.tunnels[0].public_url')
echo "env variable WEBHOOK_URL:"
echo "$WEBHOOK_URL"
