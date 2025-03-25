"use client";

import { useSongsList } from "@/hooks";
import { useRouter } from "next/navigation";
import { useState } from "react";

export default function useAddSong() {
  const { addSong } = useSongsList();
  const router = useRouter();

  const [formData, setFormData] = useState({
    title: "",
    lyrics: "",
    duration: 0,
    image_url: "https://picsum.photos/seed//300/300",
  });
  const [isLoading, setIsLoading] = useState(false);

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

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    setIsLoading(true);

    addSong({
      title: formData.title,
      composer: "",
      duration: formData.duration,
      lyrics: formData.lyrics,
      release_date: "",
      track_number: 0,
      album_id: null,
      artist_id: 1,
      file_url: "",
      image_url: formData.image_url,
    });

    setTimeout(() => {
      setIsLoading(false);
      router.push("/songs");
    }, 500);
  };

  return { formData, handleChange, handleSubmit, isLoading };
}
