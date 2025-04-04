import Link from "next/link"
import { MusicIcon } from "lucide-react"

export default function LandingPage() {
  return (
    <div className="flex min-h-screen flex-col">
      <header className="sticky top-0 z-40 bg-red-900 flex justify-center rounded-b-2xl">
        <div className="container flex h-16 items-center justify-between py-4 px-1.5">
          <div className="flex items-center gap-2">
            <MusicIcon className="h-6 w-6 text-primary" />
            <span className="text-xl font-bold">SoundWave</span>
          </div>

          <nav className="hidden md:flex items-center gap-6">
            <Link href="/sections/artists" className="text-sm font-medium hover:underline">
              Artist
            </Link>
            <Link href="/sections/songs" className="text-sm font-medium hover:underline">
              Songs
            </Link>
            <Link href="/sections/albums" className="text-sm font-medium hover:underline">
              Albums
            </Link>
          </nav>

          <nav className="md:hidden items-center gap-6">
            <Link href="/sections/songs" className="text-sm font-medium hover:underline">
              Sections
            </Link>
          </nav>

        </div>
      </header>

      <div className="w-full py-2 flex justify-center px-1.5">
        <div className="container text-center">
          <p className="text-sm font-medium">
            <span className="font-bold">Practice Environment:</span> This site is for testing CRUD operations with a
            Java server using ORM
          </p>
        </div>
      </div>

      <main className="flex-1">
        <section className="w-full py-12 md:py-24 lg:py-32 bg-gradient-to-b from-background to-muted">
          <div className="container px-4 md:px-6">
            <div className="grid gap-6 lg:grid-cols-2 lg:gap-12 items-center">
              <div className="space-y-4">
                <h1 className="text-3xl font-bold tracking-tighter sm:text-4xl md:text-5xl lg:text-6xl">
                  Your Music, Your Way
                </h1>
                <p className="max-w-[600px] text-muted-foreground md:text-xl">
                  This is a practice environment designed for testing CRUD (Create, Read, Update, Delete) operations
                  with a Java server using ORM. The interface mimics a music streaming service but is intended for
                  development purposes only.
                </p>
              </div>
            </div>
          </div>
        </section>

        <section className="w-full flex justify-center">
          <div className="container py-12 md:py-24 lg:py-32 bg-zinc-900 rounded-3xl flex flex-col items-center justify-center">
            <div className="flex flex-col items-center justify-center space-y-4 text-center px-1.5">
              <div className="space-y-2">
                <h2 className="text-3xl font-bold tracking-tighter sm:text-4xl md:text-5xl">
                  CRUD Testing Environment
                </h2>
                <p className="max-w-[900px] text-muted-foreground md:text-xl/relaxed lg:text-base/relaxed xl:text-xl/relaxed">
                  This platform is specifically designed for practicing and testing database operations
                </p>
              </div>
            </div>

            <div className="mx-auto grid max-w-5xl items-center gap-6 py-12 lg:grid-cols-4 px-1.5">
              <div className="grid gap-2 text-center">
                <div className="mx-auto flex h-16 w-16 items-center justify-center rounded-full bg-red-800">
                  <span className="text-xl font-bold text-primary">C</span>
                </div>
                <h3 className="text-xl font-bold">Create</h3>
                <p className="text-muted-foreground">Test adding new records to your Java database</p>
              </div>
              <div className="grid gap-2 text-center">
                <div className="mx-auto flex h-16 w-16 items-center justify-center rounded-full bg-red-800">
                  <span className="text-xl font-bold text-primary">R</span>
                </div>
                <h3 className="text-xl font-bold">Read</h3>
                <p className="text-muted-foreground">Practice retrieving and displaying data from your ORM</p>
              </div>
              <div className="grid gap-2 text-center">
                <div className="mx-auto flex h-16 w-16 items-center justify-center rounded-full bg-red-800">
                  <span className="text-xl font-bold text-primary">U</span>
                </div>
                <h3 className="text-xl font-bold">Update</h3>
                <p className="text-muted-foreground">Test modifying existing records in your database</p>
              </div>
              <div className="grid gap-2 text-center">
                <div className="mx-auto flex h-16 w-16 items-center justify-center rounded-full bg-red-800">
                  <span className="text-xl font-bold text-primary">D</span>
                </div>
                <h3 className="text-xl font-bold">Delete</h3>
                <p className="text-muted-foreground">Practice removing data safely from your Java backend</p>
              </div>
            </div>
          </div>
        </section>
      </main>

      <footer className="bg-red-900 rounded-t-2xl flex justify-center mt-1">
        <div className="container flex flex-col gap-6 py-4 px-1.5 md:flex-row md:items-center md:justify-between md:py-8">
          <div className="text-sm text-muted-foreground">
            © {new Date().getFullYear()} SoundWave - Practice Environment for Java ORM CRUD Operations
          </div>
        </div>
      </footer>
    </div>
  )
}