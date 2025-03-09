"use client";

import { useMusic } from "@/context/MusicContext";
import type { Song } from "@/utils/const.def";
import { useState, useEffect, FormEvent } from "react";
import { useParams, useRouter } from "next/navigation";

export default function Edit() {
  const { getMusicById, updateMusic } = useMusic();
  const params = useParams();
  const router = useRouter();
  const id = parseInt(params.id as string);
  
  const [song, setSong] = useState<Song | null>(null);
  const [formData, setFormData] = useState({
    title: "",
    lyrics: "",
    duration: 0,
    image_url: ""
  });
  const [isLoading, setIsLoading] = useState(false);
  
  // Cargar datos de la canción cuando se monta el componente
  useEffect(() => {
    if (id) {
      const songData = getMusicById(id);
      setSong(songData);
      
      if (songData) {
        setFormData({
          title: songData.title,
          lyrics: songData.lyrics,
          duration: songData.duration,
          image_url: songData.image_url
        });
      }
    }
  }, [id, getMusicById]);
  
  // Manejar cambios en los campos del formulario
  const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: name === "duration" ? parseInt(value) : value
    }));
  };
  
  // Manejar envío del formulario
  const handleSubmit = (e: FormEvent) => {
    e.preventDefault();
    setIsLoading(true);
    
    updateMusic(id, formData);
    
    // Simular un pequeño retardo para mostrar el estado de carga
    setTimeout(() => {
      setIsLoading(false);
      router.push("/songs"); // Redirigir a la página principal después de guardar
    }, 500);
  };
  
  if (!song) {
    return <div className="p-8 text-center">Cargando canción...</div>;
  }
  
  return (
    <div className="w-full mx-auto p-6 bg-zinc-900 rounded-xl">
      <h1 className="text-2xl font-bold mb-6">Editar Canción</h1>
      
      <form onSubmit={handleSubmit} className="space-y-4">
        <div>
          <label htmlFor="title" className="block mb-1">Título</label>
          <input
            type="text"
            id="title"
            name="title"
            value={formData.title}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700"
            required
          />
        </div>
        
        <div>
          <label htmlFor="lyrics" className="block mb-1">Letra</label>
          <textarea
            id="lyrics"
            name="lyrics"
            value={formData.lyrics}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 h-32"
          />
        </div>
        
        <div>
          <label htmlFor="duration" className="block mb-1">Duración (segundos)</label>
          <input
            type="number"
            id="duration"
            name="duration"
            value={formData.duration}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700"
            min="1"
            required
          />
        </div>
        
        <div>
          <label htmlFor="image_url" className="block mb-1">URL de la imagen</label>
          <input
            type="text"
            id="image_url"
            name="image_url"
            value={formData.image_url}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700"
            required
          />
        </div>
        
        <div className="flex space-x-4 pt-4">
          <button
            type="button"
            onClick={() => router.push("/songs")}
            className="px-4 py-2 rounded bg-zinc-700 hover:bg-zinc-600 transition-colors"
          >
            Cancelar
          </button>
          <button
            type="submit"
            className="px-4 py-2 rounded bg-red-600 hover:bg-red-500 transition-colors"
            disabled={isLoading}
          >
            {isLoading ? "Guardando..." : "Guardar Cambios"}
          </button>
        </div>
      </form>
    </div>
  );
}