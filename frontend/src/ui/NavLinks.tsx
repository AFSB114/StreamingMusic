"use client";

import Link from "next/link";
import { usePathname } from "next/navigation";

// Map of links to display in the side navigation.
// Depending on the size of the application, this would be stored in a database.
const links = [
  { name: "Home", href: "/" },
  { name: "Songs", href: "/songs" },
  { name: "Albums", href: "/albums" },
  { name: "Artists", href: "/artists" },
  { name: "Playlists", href: "/playlists" },
];

export default function NavLinks() {
  const pathname = usePathname();
  return (
    <>
      {links.map((link) => {
        return (
          <Link
            key={link.name}
            href={link.href}
            className={ `flex h-[48px] grow items-center justify-center gap-2 p-3 text-sm font-medium hover:bg-red-600/60 hover:text-zinc-50 md:flex-none md:justify-start md:p-2 md:px-3 duration-250 ${pathname === link.href ? "bg-red-600/50" : ""}`}
          >
            <p className="hidden md:block">{link.name}</p>
          </Link>
        );
      })}
    </>
  );
}
