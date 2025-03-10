"use client";

import { useEditSong } from "@/hooks/useEditSong";

export default function Edit() {
  const { song, formData, isLoading, handleChange, handleSubmit, router } = useEditSong();

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
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700"
            required
            disabled
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
