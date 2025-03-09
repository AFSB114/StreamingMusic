import { useState } from "react";
import songs from "@/mocks/songs.json";

const useMusics = () => {
  // Asegúrate de que songs.songs se copie, no solo se referencie
  const [musics, setMusics] = useState(() => [...songs.songs]);

  const deleteMusic = (id: number) => {
    setMusics(prevMusics => prevMusics.filter(song => song.id !== id));
    console.log(musics);
  };

  return { musics, deleteMusic };
};

export default useMusics;