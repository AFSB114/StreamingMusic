"use client";

import CustomSelect from "@/components/CustomSelect";
import {
  useAlbumsList,
  useArtistsList,
  useEditSong,
  useGenresList,
} from "@/hooks";
import Loading from "@/ui/Loading";
import NotFound from "@/ui/NotFound";
import Image from "next/image";
import { useRouter } from "next/navigation";

export default function EditSongPage() {
  const { formData, handleChange, handleSubmit, isLoading, isFound, id } =
    useEditSong();
  const { artistsList } = useArtistsList();
  const { albumsList } = useAlbumsList();
  const { genresList } = useGenresList();
  const router = useRouter();

  if (isFound === null) {
    return <Loading />;
  }

  if (!isFound) {
    return <NotFound section="Artist" />;
  }

  return (
    <div className="w-full mx-auto p-6 bg-zinc-900 rounded-xl overflow-y-auto">
      <h2 className="text-2xl font-bold mb-6">Edit Song {id}</h2>

      <form className="space-y-4" onSubmit={handleSubmit}>
        <div>
          <CustomSelect
            name="albumId"
            label="Album"
            options={albumsList}
            value={
              formData.albumId?.id === undefined || formData.albumId === null
                ? ""
                : formData.albumId.id.toString()
            }
            onChange={handleChange}
            optionLabelKey="title"
            optionValueKey="id"
            placeholder="Select Album"
            maxHeight="150px"
            required
          />
        </div>

        <div>
          <CustomSelect
            name="artistId"
            label="Artist"
            options={artistsList}
            value={
              formData.artistId.id === undefined
                ? ""
                : formData.artistId.id.toString()
            }
            onChange={handleChange}
            optionLabelKey="name"
            optionValueKey="id"
            placeholder="Select Artist"
            maxHeight="150px"
            required
          />
        </div>

        <div>
          <label htmlFor="title" className="block mb-1">
            Title
          </label>
          <input
            type="text"
            id="title"
            name="title"
            value={formData.title}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            required
          />
        </div>

        <div>
          <label htmlFor="composer" className="block mb-1">
            Composer
          </label>
          <input
            type="text"
            id="composer"
            name="composer"
            value={formData.composer === null ? "" : formData.composer}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
          />
        </div>

        <div>
          <label htmlFor="duration" className="block mb-1">
            Duration (in seconds)
          </label>
          <input
            type="number"
            id="duration"
            name="duration"
            value={formData.duration}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            required
            min={0}
          />
        </div>

        <div>
          <label htmlFor="lyrics" className="block mb-1">
            Lyrics
          </label>
          <textarea
            id="lyrics"
            name="lyrics"
            value={formData.lyrics === null ? "" : formData.lyrics}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            rows={4}
          />
        </div>

        <div>
          <label htmlFor="releaseDate" className="block mb-1">
            Release Date
          </label>
          <input
            type="date"
            id="releaseDate"
            name="releaseDate"
            value={formData.releaseDate || ""}
            onChange={handleChange}
            max={new Date().toISOString().split("T")[0]}
            min={new Date(1900, 0, 1).toISOString().split("T")[0]}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            required
          />
        </div>

        <div>
          <label htmlFor="fileUrl" className="block mb-1">
            File URL
          </label>
          <input
            type="url"
            id="fileUrl"
            name="fileUrl"
            value={formData.fileUrl === null ? "" : formData.fileUrl}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            required
            readOnly
          />
        </div>

        <div>
          <label htmlFor="imageUrl" className="block mb-1">
            Image URL
          </label>
          <input
            type="url"
            id="imageUrl"
            name="imageUrl"
            value={formData.imageUrl === null ? "" : formData.imageUrl}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            required
            readOnly
          />
        </div>

        {formData.imageUrl && (
          <div>
            <Image
              src={formData.imageUrl}
              alt="Song image"
              width={300}
              height={300}
              className="object-cover"
            />
          </div>
        )}

        <div>
          <CustomSelect
            name="genreId"
            label="Genres"
            options={genresList}
            value={
              formData.genreId?.id === undefined || formData.genreId === null
                ? ""
                : formData.genreId.id.toString()
            }
            onChange={handleChange}
            optionLabelKey="name"
            optionValueKey="id"
            placeholder="Select Genre"
            maxHeight="150px"
            required
          />
        </div>

        <div className="flex space-x-4 pt-4">
          <button
            type="button"
            className="px-4 py-2 rounded bg-zinc-700 hover:bg-zinc-600 transition-colors"
            onClick={() => router.push("/sections/songs")}
          >
            Cancel
          </button>
          <button
            type="submit"
            className="px-4 py-2 rounded bg-red-600 hover:bg-red-500 transition-colors"
            disabled={isLoading}
          >
            {isLoading ? "Saving..." : "Save"}
          </button>
        </div>
      </form>
    </div>
  );
}
