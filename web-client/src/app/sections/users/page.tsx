"use client";

import UserCard from "@/components/UserCard";
import useUsersList from "@/hooks/user/useUsersList";
import { PlusCircle, Search } from "lucide-react";
import Link from "next/link";

export default function SongPage() {
  const { usersList } = useUsersList();

  return (
    <div className="relative overflow-y-auto max-h-full rounded-xl bg-zinc-900 p-3 shadow-sm">
      <div className="sticky top-0 z-40 flex justify-between items-center mb-5 bg-zinc-900 p-2 rounded-lg shadow-lg">
        <div className="w-max">
          <Link href="/sections/users/add">
            <button className="text-1xl sm:text-2xl gap-2 rounded-xl flex flex-row items-center justify-center transition-colors duration-200 hover:bg-green-600 p-3 hover:cursor-pointer">
              <PlusCircle className="h-6 w-6" />
              <span>Add User</span>
            </button>
          </Link>
        </div>
        <form className="flex gap-2 items-center">
          <div>
            <button
              type="submit"
              className="text-1xl sm:text-2xl rounded-xl flex flex-row items-center justify-center transition-colors duration-200 hover:bg-red-800 p-3 hover:cursor-pointer"
            >
              <Search className="h-6 w-6" />
            </button>
          </div>
          <div>
            <input
              type="text"
              id="search"
              name="search"
              placeholder="Search..."
              className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            />
          </div>
          <div>
            <select
              name="genre"
              id="genre"
              className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            >
              <option value="">Select Genre</option>
            </select>
          </div>
        </form>
      </div>

      <div className="grid sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-3">
        {usersList
          .sort((a, b) => a.id - b.id)
          .map((user) => (
            <UserCard user={user} key={user.id} />
          ))}
      </div>
    </div>
  );
}
