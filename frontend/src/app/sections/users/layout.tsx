"use client";

import { GenreProvider } from "@/context/providers/GenreProvider";
import { UserProvider } from "@/context/providers/UserProvider";

export default function UserLayout({
  children,
}: Readonly<{ children: React.ReactNode }>) {
  return (
    <UserProvider>
      <GenreProvider>{children}</GenreProvider>
    </UserProvider>
  );
}
