"use client";

import { useSongsList } from "@/hooks";
import type { SongType } from "@/types";
import { useState, useEffect, FormEvent } from "react";
import { useParams, useRouter } from "next/navigation";

export default function useEditSong() {
  const { getSongById, updateSongsList } = useSongsList();
  const params = useParams();
  const router = useRouter();
  const id = parseInt(params.id as string);

  const [song, setSong] = useState<SongType | null>(null);
  const [formData, setFormData] = useState({
    title: "",
    lyrics: "",
    duration: 0,
    image_url: "",
  });
  const [isLoading, setIsLoading] = useState(false);

  // Cargar datos de la canción cuando se monta el componente
  useEffect(() => {
    if (id) {
      const songData = getSongById(id);
      setSong(songData);

      if (songData) {
        setFormData({
          title: songData.title,
          lyrics: songData.lyrics,
          duration: songData.duration,
          image_url: songData.image_url,
        });
      }
    }
  }, [id, getSongById]);

  // Manejar cambios en los campos del formulario
  const handleChange = (
    e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>
  ) => {
    const { name, value } = e.target;

    // Actualizar el estado según el campo que cambió
    if (name === "title") {
      // Si el título cambia, actualizar tanto el título como la URL de la imagen
      const formattedTitle = value.trim().replace(/\s+/g, "").toLowerCase(); // Eliminar espacios
      setFormData((prev) => ({
        ...prev,
        title: value,
        image_url: `https://picsum.photos/seed/${formattedTitle}/300/300`,
      }));
    } else {
      // Para otros campos, actualizar normalmente
      setFormData((prev) => ({
        ...prev,
        [name]: name === "duration" ? parseInt(value) : value,
      }));
    }
  };

  // Manejar envío del formulario
  const handleSubmit = (e: FormEvent) => {
    e.preventDefault();
    setIsLoading(true);

    updateSongsList(id, formData);

    setTimeout(() => {
      setIsLoading(false);
      router.push("/songs");
    }, 500);
  };

  return { song, formData, isLoading, handleChange, handleSubmit, router };
}
