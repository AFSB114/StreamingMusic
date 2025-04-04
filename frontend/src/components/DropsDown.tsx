"use client";

import { useState } from "react";
import { ChevronDown } from "lucide-react";
import { LinkType } from "@/types";
import Link from "next/link";

export default function Dropdown({
  links,
  className = "",
}: Readonly<{ links: LinkType[]; className?: string }>) {
  const [isOpen, setIsOpen] = useState(false);

  const toggleDropdown = () => setIsOpen(!isOpen);

  return (
    <div className={`relative w-full ${className}`}>
      {/* Dropdown Button */}
      <button
        onClick={toggleDropdown}
        className="w-full flex justify-between items-center bg-white border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 p-2.5 hover:bg-gray-100 transition-colors"
      >
        <ChevronDown
          className={`h-5 w-5 transform transition-transform duration-200 ${
            isOpen ? "rotate-180" : ""
          }`}
        />
      </button>

      {/* Dropdown Menu */}
      {isOpen && (
        <ul className="absolute z-40 w-full mt-1 bg-white border border-gray-300 rounded-lg shadow-lg max-h-60 overflow-auto">
          {links.map((link, index) => (
            <li key={index} className="px-4 py-2 text-sm cursor-pointer">
              <Link href={link.href}>{link.name}</Link>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}
