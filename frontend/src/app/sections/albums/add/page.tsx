"use client";

import CustomSelect from "@/components/CustomSelect";
import { useAddAlbum, useArtistsList, useRecordLabelsList } from "@/hooks";
import Image from "next/image";
import { useRouter } from "next/navigation";
import { albumTypes } from "@/constants";

export default function AddAlbumPage() {
  const { formData, handleChange, handleSubmit, isLoading } = useAddAlbum();
  const { artistsList } = useArtistsList();
  const { recordLabelsList } = useRecordLabelsList();
  const router = useRouter();

  return (
    <div className="w-full mx-auto p-6 bg-zinc-900 rounded-xl overflow-y-auto">
      <h2 className="text-2xl font-bold mb-6">Create Album</h2>

      <form className="space-y-4" onSubmit={handleSubmit}>
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
          <CustomSelect
            name="artistId"
            label="Artist"
            options={artistsList}
            value={formData.artistId.id === undefined ? "" : formData.artistId.id.toLocaleString()}
            onChange={handleChange}
            optionLabelKey="name"
            optionValueKey="id"
            placeholder="Select Artist"
            maxHeight="150px"
            required
          />
        </div>

        <div>
        <CustomSelect
            name="recordLabeId"
            label="Record Label"
            options={recordLabelsList}
            value={formData.recordLabelId.id === undefined ? "" : formData.recordLabelId.id.toLocaleString()}
            onChange={handleChange}
            optionLabelKey="name"
            optionValueKey="id"
            placeholder="Select Record Label"
            maxHeight="150px"
            required
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
          <label htmlFor="description" className="block mb-1">
            Description
          </label>
          <textarea
            id="description"
            name="description"
            value={formData.description || ""}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            rows={4}
          />
        </div>

        <div>
          <label htmlFor="coverUrl" className="block mb-1">
            Cover URL
          </label>
          <input
            type="url"
            id="coverUrl"
            name="coverUrl"
            value={formData.coverUrl || ""}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            required
            readOnly
          />
        </div>

        {formData.coverUrl && (
          <div>
            <Image
              src={formData.coverUrl}
              alt="Album cover"
              width={300}
              height={300}
              className="object-cover"
            />
          </div>
        )}

        <div>
        <CustomSelect
            name="type"
            label="Type"
            options={albumTypes}
            value={formData.type === null ? "" : formData.type}
            onChange={handleChange}
            optionLabelKey="label"
            optionValueKey="value"
            placeholder="Select Type"
            maxHeight="150px"
          />
        </div>

        <div className="flex space-x-4 pt-4">
          <button
            type="button"
            className="px-4 py-2 rounded bg-zinc-700 hover:bg-zinc-600 transition-colors"
            onClick={() => router.push("/sections/albums")}
          >
            Cancel
          </button>
          <button
            type="submit"
            className="px-4 py-2 rounded bg-red-600 hover:bg-red-500 transition-colors"
          >
            {isLoading ? "Saving..." : "Save"}
          </button>
        </div>
      </form>
    </div>
  );
}
