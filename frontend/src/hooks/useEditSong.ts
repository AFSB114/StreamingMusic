"use client";

import { useSongsList } from "@/hooks/useSongsList";
import type { songType } from "@/types";
import { useState, useEffect, FormEvent } from "react";
import { useParams, useRouter } from "next/navigation";

export function useEditSong() {
  const { getSongById, updateSongsList } = useSongsList();
  const params = useParams();
  const router = useRouter();
  const id = parseInt(params.id as string);

  const [song, setSong] = useState<songType | null>(null);
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
    setFormData((prev) => ({
      ...prev,
      [name]: name === "duration" ? parseInt(value) : value,
    }));
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
