"use client";

import Image from "next/image";
import { useRouter } from "next/navigation"
import useAddSong from "@/hooks/song/useAddSong";

export default function AddSongPage() {
  const router = useRouter();
  const { formData, handleChange, handleSubmit, isLoading } = useAddSong();

  return (
    <div className="w-full mx-auto p-6 bg-zinc-900 rounded-xl overflow-y-auto">
      <h1 className="text-2xl font-bold mb-6">Editar Canción</h1>

      <form className="space-y-4" onSubmit={handleSubmit}>
        <div>
          <label htmlFor="title" className="block mb-1">
            Título
          </label>
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
          <label htmlFor="lyrics" className="block mb-1">
            Letra
          </label>
          <textarea
            id="lyrics"
            name="lyrics"
            value={formData.lyrics}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 h-32"
          />
        </div>

        <div>
          <label htmlFor="duration" className="block mb-1">
            Duración (segundos)
          </label>
          <input
            type="number"
            id="duration"
            name="duration"
            value={formData.duration > 0 ? formData.duration : 1}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700"
            min="1"
            required
          />
        </div>

        <div>
          <label htmlFor="image_url" className="block mb-1">
            URL de la imagen
          </label>
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

        <div>
          <Image
            src={formData.image_url}
            alt="Song cover"
            width={300}
            height={300}
            className="object-cover"
          />
        </div>

        <div className="flex space-x-4 pt-4">
          <button
            type="button"
            className="px-4 py-2 rounded bg-zinc-700 hover:bg-zinc-600 transition-colors"
            onClick={() => router.push("/songs")}
          >
            Cancelar
          </button>
          <button
            type="submit"
            className="px-4 py-2 rounded bg-red-600 hover:bg-red-500 transition-colors"
            disabled={isLoading}
          >
            {isLoading ? "Agregando..." : "Agregar"}
          </button>
        </div>
      </form>
    </div>
  );
}
