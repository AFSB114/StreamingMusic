"use client";

import Image from "next/image";
import { useRouter } from "next/navigation";
import { useAddUser } from "@/hooks"; // Suponiendo que tienes este hook

export default function AddUserPage() {
  const { formData, handleChange, handleSubmit, isLoading } = useAddUser();
  const router = useRouter();

  return (
    <div className="w-full mx-auto p-6 bg-zinc-900 rounded-xl overflow-y-auto">
      <h2 className="text-2xl font-bold mb-6">Create User</h2>

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
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700"
            required
            maxLength={255}
          />
        </div>

        <div>
          <label htmlFor="email" className="block mb-1">
            Email
          </label>
          <input
            type="email"
            id="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700"
            required
            maxLength={255}
          />
        </div>

        <div>
          <label htmlFor="password" className="block mb-1">
            Password
          </label>
          <input
            type="password"
            id="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700"
            required
            maxLength={255}
          />
        </div>

        <div>
          <label htmlFor="country" className="block mb-1">
            Country
          </label>
          <input
            type="text"
            id="country"
            name="country"
            value={formData.country ?? ""}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700"
            maxLength={100}
          />
        </div>

        <div>
          <label htmlFor="profileImage" className="block mb-1">
            Profile Image URL
          </label>
          <input
            type="url"
            id="profileImage"
            name="profileImage"
            value={formData.profileImage ?? ""}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700"
            maxLength={255}
          />
        </div>

        {formData.profileImage && (
          <div>
            <Image
              src={formData.profileImage}
              alt="Profile"
              width={300}
              height={300}
              className="object-cover"
            />
          </div>
        )}

        <div className="flex space-x-4 pt-4">
          <button
            type="button"
            className="px-4 py-2 rounded bg-zinc-700 hover:bg-zinc-600 transition-colors"
            onClick={() => router.push("/sections/users")}
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
