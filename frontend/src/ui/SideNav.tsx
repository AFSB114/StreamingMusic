import Link from "next/link";
import NavLinks from "./NavLinks";
import Image from "next/image";

const logo = require("@/assets/images/logo-1.png");

export default function SideNav() {
  return (
    <div className="flex h-full flex-col px-3 py-4 md:px-2">
      <Link
        className="mb-2 flex flex-col h-20 items-center justify-start rounded-md p-4 md:h-40 bg-red-600/50 hover:bg-red-600/60"
        href="/"
      >
        <Image
          src={logo}
          alt="Logo"
          width={200}
          height={200}
          className="h-auto w-auto md:h-25 md:w-25"
        />
        <div className="w-32 text-white md:w-40 text-2xl font-bold text-center">SoundWave</div>
      </Link>
      <div className="flex grow flex-row justify-between space-x-0.5 md:flex-col md:space-x-0 md:space-y-2">
        <div className="hidden h-auto w-full grow rounded-md md:block overflow-clip bg-zinc-900">
          <NavLinks />
        </div>
      </div>
    </div>
  );
}
