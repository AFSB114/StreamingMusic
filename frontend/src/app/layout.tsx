import SideNav from "@/ui/SideNav";
import "./globals.css";

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body>
        <div className="flex h-screen flex-col md:flex-row overflow-hidden">
          <div className="w-full flex-none md:w-50">
            <SideNav />
          </div>
          <div className="flex-grow md:p-6 p-3 rounded-lg overflow-hidden flex flex-col">
            {children}
          </div>
        </div>
      </body>
    </html>
  );
}
