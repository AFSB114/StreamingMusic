export function getMusics() {
  return fetch("https://ws.audioscrobbler.com/2.0/?method=chart.gettoptracks&api_key=4060ccd6643d4373a2b4627e377814c8&format=json")
    .then((res) => res.json())
    .then((data) => {
      console.log(data.tracks.track);
      return data.tracks.track;
    });
}