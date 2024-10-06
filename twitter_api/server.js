const express = require('express');
const axios = require('axios');
const dotenv = require('dotenv');

dotenv.config();  // Cargar las variables de entorno del archivo .env

const app = express();
const port = 3000;

// Ruta para obtener tweets con hashtag #MYFIELD
app.get('/tweets', async (req, res) => {
    try {
        const response = await axios.get('https://api.twitter.com/2/tweets/search/recent', {
            headers: {
                'Authorization': `Bearer ${process.env.TWITTER_BEARER_TOKEN}`
            },
            params: {
                'query': '#MYFIELD has:geo', // Buscar tweets con el hashtag #MYFIELD y que tengan geolocalización
                'tweet.fields': 'geo', // Solo queremos tweets que tengan datos de geolocalización
                'expansions': 'geo.place_id', // Expandir para obtener información de la localización
                'place.fields': 'full_name,geo' // Incluir detalles del lugar
            }
        });

        res.json(response.data);
    } catch (error) {
        console.error(error);
        res.status(500).json({ message: 'Error al obtener tweets' });
    }
});

// Iniciar el servidor
app.listen(port, () => {
    console.log(`Servidor corriendo en http://localhost:${port}`);
});
