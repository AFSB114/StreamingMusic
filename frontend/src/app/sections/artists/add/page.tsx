"use client";

import { useAddArtist } from "@/hooks";
import Image from "next/image";
import { useRouter } from "next/navigation";

export default function AddArtistPage() {
  const { formData, handleChange, handleSubmit, isLoading } = useAddArtist();
  const router = useRouter();

  return (
    <div className="w-full mx-auto p-6 bg-zinc-900 rounded-xl overflow-y-auto">
      <h2 className="text-2xl font-bold mb-6">Create Artist</h2>

      <form className="space-y-4" onSubmit={handleSubmit}>
        <div>
          <label htmlFor="name" className="block mb-1">
            Name
          </label>
          <input
            type="text"
            id="name"
            name="name"
            value={formData.name}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            required
          />
        </div>

        <div>
          <label htmlFor="biography" className="block mb-1">
            Biography
          </label>
          <textarea
            id="biography"
            name="biography"
            value={formData.biography === null ? "" : formData.biography}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            rows={4}
          />
        </div>

        <div>
          <label htmlFor="countryOfOrigin" className="block mb-1">
            Country of Origin
          </label>
          <input
            type="text"
            id="countryOfOrigin"
            name="countryOfOrigin"
            value={
              formData.countryOfOrigin === null
                ? ""
                : formData.countryOfOrigin
            }
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
          />
        </div>

        <div>
          <label htmlFor="debutDate" className="block mb-1">
            Debut Date
          </label>
          <input
            type="date"
            id="debutDate"
            name="debutDate"
            value={formData.debutDate || ""} // Asegurar que no sea null
            onChange={handleChange}
            max={new Date().toISOString().split("T")[0]}
            min={new Date(1900, 0, 1).toISOString().split("T")[0]}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
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
            value={formData.imageUrl}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            required
            readOnly
          />
        </div>

        <div>
          <Image
            src={formData.imageUrl}
            alt="Song cover"
            width={300}
            height={300}
            className="object-cover"
          />
        </div>

        <div>
          <label htmlFor="type" className="block mb-1">
            Type
          </label>
          <select
            id="type"
            name="type"
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            value={formData.type === null ? "" : formData.type}
            onChange={handleChange}
          >
            <option value="">Select Type</option>
            <option value="Solo">Solo</option>
            <option value="Band">Band</option>
            <option value="Group">Group</option>
          </select>
        </div>

        <div className="flex space-x-4 pt-4">
          <button
            type="button"
            className="px-4 py-2 rounded bg-zinc-700 hover:bg-zinc-600 transition-colors"
            onClick={() => router.push("/sections/artists")}
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
